/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.entity.Gmap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.event.map.ReverseGeocodeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author aburgos
 */
@ManagedBean(name = "cntGeocode")
@ViewScoped
public class CntGeocode {
     
    private MapModel geoModel;
    private String centerGeoMap = "-12.046374, -77.0427934";
    private Gmap gmap;
    private Marker marker;
    @PostConstruct
    public void init() {
        geoModel = new DefaultMapModel();
        gmap = new Gmap();
        RequestContext.getCurrentInstance().execute("getLocation()");
//        onMarker();
    }
     
    public void onGeocode(GeocodeEvent event) {
        List<GeocodeResult> results = event.getResults();
        geoModel=new DefaultMapModel();
        if (results != null && !results.isEmpty()) {
            LatLng center = results.get(0).getLatLng();
            centerGeoMap = center.getLat() + "," + center.getLng();
            for (int i = 0; i < results.size(); i++) {
                GeocodeResult result = results.get(i);
                marker=new Marker(result.getLatLng(), result.getAddress());
                marker.setDraggable(true);
                geoModel.addOverlay(marker);
            }
            gmap.setLatitud(""+center.getLat());
            gmap.setLongitud(""+center.getLng());
            RequestContext.getCurrentInstance().update("lat");
            RequestContext.getCurrentInstance().update("lng");
        }
    }
    public void onReverseGeocode(ReverseGeocodeEvent event) {
        List<String> addresses = event.getAddresses();
        LatLng coord = event.getLatlng();
        geoModel=new DefaultMapModel(); 
        if (addresses != null && !addresses.isEmpty()) {
            centerGeoMap = coord.getLat() + "," + coord.getLng();
            marker=new Marker(coord, addresses.get(0));
            marker.setDraggable(true);
            geoModel.addOverlay(marker);
        }
        gmap.setDireccion(addresses.get(0));
        gmap.setLatitud(""+coord.getLat());
        gmap.setLongitud(""+coord.getLng());
        RequestContext.getCurrentInstance().update("address");
    }
    public void onMarkerDrag(MarkerDragEvent event) {
        setMarker(event.getMarker());
        gmap.setLatitud(""+getMarker().getLatlng().getLat());
        gmap.setLongitud(""+getMarker().getLatlng().getLng());
        RequestContext.getCurrentInstance().update("lat");
        RequestContext.getCurrentInstance().update("lng");
        RequestContext.getCurrentInstance().execute("reverseGeocode()");
    }
    public void selectFromDialog() {
        RequestContext.getCurrentInstance().closeDialog(gmap);
    }
     
    public MapModel getGeoModel() {
        return geoModel;
    }
 
    public String getCenterGeoMap() {
        return centerGeoMap;
    }

    /**
     * @return the gmap
     */
    public Gmap getGmap() {
        return gmap;
    }

    /**
     * @param gmap the gmap to set
     */
    public void setGmap(Gmap gmap) {
        this.gmap = gmap;
    }

    /**
     * @return the marker
     */
    public Marker getMarker() {
        return marker;
    }

    /**
     * @param marker the marker to set
     */
    public void setMarker(Marker marker) {
        this.marker = marker;
    }
}
