package events
{
	import flash.events.Event;
	
	import model.vo.Vehicle;
	
	public class VehicleEvent extends Event
	{
		public static const VEHICLE_SELECT : String = "VEHICLE_SELECT";
		public static const VEHICLE_REPORT : String = "VEHICLE_REPORT";
		
		public var vehicle : Vehicle;
		
		public function VehicleEvent(type:String, vehicle : Vehicle)
		{
			this.vehicle = vehicle;
			super(VEHICLE_SELECT);
		}
	}
}