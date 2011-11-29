package model.vo
{
	public class VehicleUpdate
	{
		public var vehicleId : int;
		public var latitude : Number;
		public var longitude : Number;
		public var speed : Number;
		public var direction : Number;
		
		public var updateTime : Date = new Date();
		public var vehicle : Vehicle;
	}
}