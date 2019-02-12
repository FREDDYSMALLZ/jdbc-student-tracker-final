package com.luv2code.jsf.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class SongsController {
    private List<Song> songs;
    private SongsDbUtil songsDbUtil;
    private Logger logger = Logger.getLogger(getClass().getName());

    public SongsController() throws Exception {
        songs = new ArrayList<>();

        songsDbUtil = SongsDbUtil.getInstance();
    }
    public List<Song> getSongs() {
        return songs;
    }

    public void loadSongs() {

        logger.info("Loading songs");

        songs.clear();

        try {

            // get all songs from database
            songs = songsDbUtil.getSongs();

        } catch (Exception exc) {
            // send this to server logs
            logger.log(Level.SEVERE, "Error loading songs", exc);

            // add error message for JSF page
            addErrorMessage(exc);
        }
    }
    public String addSong(Song theSong) {

        logger.info("Adding song: " + theSong);

        try {

            // add student to the database
            songsDbUtil.addSong(theSong);

        } catch (Exception exc) {
            // send this to server logs
            logger.log(Level.SEVERE, "Error adding songs", exc);

            // add error message for JSF page
            addErrorMessage(exc);

            return null;
        }

        return "list-songs?faces-redirect=true";
    }

    public String loadSong(int songId) {

        logger.info("loading student: " + songId);

        try {
            // get student from database
            Song theSong = songsDbUtil.getSong(songId);

            // put in the request attribute ... so we can use it on the form page
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

            Map<String, Object> requestMap = externalContext.getRequestMap();
            requestMap.put("song", theSong);

        } catch (Exception exc) {
            // send this to server logs
            logger.log(Level.SEVERE, "Error loading song id:" + songId, exc);

            // add error message for JSF page
            addErrorMessage(exc);

            return null;
        }
        return "update-student-form.xhtml";
    }
    public String updateSong(Song theSong) {

        logger.info("updating song: " + theSong);

        try {

            // update student in the database
            songsDbUtil.updateSong(theSong);

        } catch (Exception exc) {
            // send this to server logs
            logger.log(Level.SEVERE, "Error updating song: " + theSong, exc);

            // add error message for JSF page
            addErrorMessage(exc);

            return null;
        }

        return "list-songs?faces-redirect=true";
    }
    public String deleteSong(int songId) {

        logger.info("Deleting song id: " + songId);

        try {

            // delete the student from the database
            songsDbUtil.deleteSong(songId);

        } catch (Exception exc) {
            // send this to server logs
            logger.log(Level.SEVERE, "Error deleting song id: " + songId, exc);

            // add error message for JSF page
            addErrorMessage(exc);

            return null;
        }

        return "list-songs";
    }

    private void addErrorMessage(Exception exc) {
        FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
