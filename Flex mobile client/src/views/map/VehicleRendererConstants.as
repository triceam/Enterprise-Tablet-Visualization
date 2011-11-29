package views.map
{
	import flash.display.Bitmap;

	public class VehicleRendererConstants
	{
		
		[Embed(source="/assets/images/vehicle_red.png")]
		private static var RedIcon:Class;
		[Embed(source="/assets/images/vehicle_green.png")]
		private static var GreenIcon:Class;
		
		public static var RED_ICON : Bitmap = new RedIcon();
		public static var GREEN_ICON : Bitmap = new GreenIcon();
		
		public static const SPEED_THRESHOLD : Number = 75;
	}
}