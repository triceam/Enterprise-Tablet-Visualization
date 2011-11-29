package model
{
	import flash.net.registerClassAlias;
	
	import model.vo.Vehicle;
	import model.vo.VehicleUpdate;
	
	import mx.collections.ArrayCollection;

	[Bindable]
	public class VehiclesModel
	{
		public var vehicles : ArrayCollection;
		public var messages : ArrayCollection;
		public var vehicleMap : Object;
		
		public function VehiclesModel()
		{
			registerClassAlias( "com.tricedesigns.enterprisedata.model.Vehicle", Vehicle );
			registerClassAlias( "com.tricedesigns.enterprisedata.model.VehicleUpdate", VehicleUpdate );
			
			vehicles = new ArrayCollection();
			messages = new ArrayCollection();
			vehicleMap = new Object();
		}
	}
}