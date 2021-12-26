package Interfaces;

import com.teamdev.jxmaps.swing.MapView;
import com.teamdev.jxmaps.*;
import java.awt.BorderLayout;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.JFrame;

/**
 *
 * @author TAHIRI
 */
public class MapPosition extends MapView{
    
    private Map map;
    public MapPosition(String nName , double Lantitude, double Longitude) {
        JFrame frame = new JFrame(nName);
        
        setOnMapReadyHandler(new MapReadyHandler() {

            @Override
            public void onMapReady(MapStatus statu) {
            
                if(statu == MapStatus.MAP_STATUS_OK)
                {
                    map = getMap();
                    MapOptions mapOptions = new MapOptions();
                    MapTypeControlOptions controlOptions = new MapTypeControlOptions();
                    mapOptions.setMapTypeControlOptions(controlOptions);
                    
                    LatLng latLng = new LatLng(Lantitude, Longitude);
                    
                    
                    map.setOptions(mapOptions);
                    map.panTo(latLng);
                    map.setZoom(5.0);
                    
                    Marker mark = new Marker(map);
                    mark.setPosition(map.getCenter());
                    
                    Circle circle = new Circle(map);
                    circle.setCenter(map.getCenter());
                    circle.setRadius(200);
                    
                    CircleOptions co = new CircleOptions();
                    co.setFillColor("#FF0000");
                    co.setFillOpacity(0.35);
                    
                    circle.setOptions(co);
                    
                }
            }
        });
    
        frame.add(this, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setSize(700, 500);
        frame.setExtendedState(MAXIMIZED_BOTH);
    }

}
