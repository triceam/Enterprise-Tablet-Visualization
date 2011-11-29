package business
{
	import flash.events.Event;
	import flash.events.IEventDispatcher;
	
	import model.VehiclesModel;
	import model.vo.Vehicle;
	import model.vo.VehicleUpdate;
	
	import mx.collections.ArrayCollection;
	import mx.messaging.Consumer;
	import mx.messaging.events.MessageEvent;
	import mx.messaging.events.MessageFaultEvent;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import org.swizframework.utils.services.ServiceHelper;

	public class VehiclesController
	{
		
		[Dispatcher]
		public var dispatcher:IEventDispatcher;
		
		[Inject( source="vehiclesService" )]
		public var service:RemoteObject;
		
		[Inject( source="mesagingConsumer" )]
		public var consumer:Consumer;
		
		[Inject]
		public var serviceHelper : ServiceHelper;
		
		[Inject]
		public var vehiclesModel : VehiclesModel;
		
		public function VehiclesController()
		{
		}
		
		[PostConstruct]
		public function loadVehicles() : void
		{
			serviceHelper.executeServiceCall( service.getVehicles(), getVehiclesResult, getVehiclesFault );
			consumer.addEventListener( MessageEvent.MESSAGE, onConsumerMessage );
			consumer.addEventListener( MessageFaultEvent.FAULT, onConsumerFault );
		}
		
		protected function getVehiclesResult( event : ResultEvent ) : void
		{
			vehiclesModel.vehicles = event.result as ArrayCollection;
			
			for each ( var vehicle : Vehicle in vehiclesModel.vehicles )
			{
				vehiclesModel.vehicleMap[ vehicle.vehicleId.toString() ] = vehicle;
			}
			
			consumer.subscribe();
		}
		
		protected function getVehiclesFault( event : FaultEvent ) : void
		{
			//do nothing for now - real apps should handle this
		}
		
		private function onConsumerMessage(event:MessageEvent):void 
		{
			var update : VehicleUpdate = event.message.body as VehicleUpdate;
			
			var vehicle : Vehicle= vehiclesModel.vehicleMap[ update.vehicleId.toString() ];
			vehicle.direction = update.direction;
			vehicle.latitude = update.latitude;
			vehicle.longitude = update.longitude;
			vehicle.speed = update.speed;
			update.vehicle = vehicle;
			
			vehiclesModel.messages.addItemAt( update, 0 );
			if ( vehiclesModel.messages.length > 100 )
			{
				update = vehiclesModel.messages.removeItemAt( 100 ) as VehicleUpdate;
				update.vehicle = null;
			}
		}
		
		private function onConsumerFault(event:MessageFaultEvent):void 
		{
			//do nothing for now - real apps should handle this
		}
		
		
		
		
		
	}
}