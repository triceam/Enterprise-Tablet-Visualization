package model.vo
{
	import flash.events.EventDispatcher;

	[Bindable]
	public class Vehicle extends EventDispatcher
	{
		public var vehicleId : int;
		public var icon : int;
		public var name : String;
		public var latitude : Number;
		public var longitude : Number;
		public var speed : Number;
		public var direction : Number;
		
		public function Vehicle()
		{
			super();
		}
	}
}