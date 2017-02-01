/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Alex Burgos <aburgosd91@gmail.com>
 */
@ManagedBean(name = "principalAction")
@SessionScoped
public class PrincipalAction {

    /**
     * Creates a new instance of PrincipalAction
     */
    private List<String> images;
    public PrincipalAction() {
        images = new ArrayList<>();
        images.add("sdr1.jpg");
        images.add("sdr2.jpg");
        images.add("sdr03.jpg");
        images.add("sdr4.jpg");
        images.add("sdr5.jpg");
        images.add("sdr6.jpg");
    }

    /**
     * @return the images
     */
    public List<String> getImages() {
        return images;
    }

    /**
     * @param images the images to set
     */
    public void setImages(List<String> images) {
        this.images = images;
    }
    
}
