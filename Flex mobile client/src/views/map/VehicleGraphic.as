package views.map
{
	import com.esri.ags.Graphic;
	import com.esri.ags.geometry.Geometry;
	import com.esri.ags.geometry.MapPoint;
	import com.esri.ags.symbols.PictureMarkerSymbol;
	import com.esri.ags.symbols.Symbol;
	import com.esri.ags.utils.WebMercatorUtil;
	
	import flash.events.Event;
	
	import model.vo.Vehicle;
	
	import mx.events.PropertyChangeEvent;
	
	public class VehicleGraphic extends Graphic
	{
		public var vehicle : Vehicle;
		
		public function VehicleGraphic(vehicle : Vehicle)
		{
			super();
			
			this.geometry = WebMercatorUtil.geographicToWebMercator(
				new MapPoint(vehicle.longitude, vehicle.latitude)) as MapPoint;
			
			this.vehicle = vehicle;
			this.vehicle.addEventListener( PropertyChangeEvent.PROPERTY_CHANGE, onPropertyChange );
			
			this.symbol = new PictureMarkerSymbol(
				(vehicle.direction >= 0 && vehicle.direction < 180) ? VehicleRendererConstants.RED_ICON : VehicleRendererConstants.GREEN_ICON,
				VehicleRendererConstants.RED_ICON.width, 
				VehicleRendererConstants.RED_ICON.height,
				-VehicleRendererConstants.RED_ICON.width/2,
				-VehicleRendererConstants.RED_ICON.height/2,
				vehicle.direction
			);
			
		}
		
		protected function onPropertyChange( evnet : Event ) : void
		{	
			PictureMarkerSymbol(this.symbol).source = (vehicle.direction >= 0 && vehicle.direction < 180) ? VehicleRendererConstants.RED_ICON : VehicleRendererConstants.GREEN_ICON;
			PictureMarkerSymbol(this.symbol).angle = this.vehicle.direction;
			this.geometry = WebMercatorUtil.geographicToWebMercator(
				new MapPoint(vehicle.longitude, vehicle.latitude)) as MapPoint;
		}
	}
}