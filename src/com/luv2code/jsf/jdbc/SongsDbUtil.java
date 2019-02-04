package com.luv2code.jsf.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class SongsDbUtil {

    private static SongsDbUtil instance;
    private DataSource dataSource;
    private String jndiName = "java:comp/env/jdbc/MusicDb";

    public static SongsDbUtil getInstance() throws Exception {
        if (instance == null) {
            instance = new SongsDbUtil();
        }

        return instance;
    }

    private SongsDbUtil() throws Exception {
        dataSource = getDataSource();
    }

    private DataSource getDataSource() throws NamingException {
        Context context = new InitialContext();

        DataSource theDataSource = (DataSource) context.lookup(jndiName);

        return theDataSource;
    }

    public List<Song> getSongs() throws Exception {

        List<Song> songs = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = getConnection();

            String sql = "select * from musicTbl order by albumTitle";

            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery(sql);

            // process result set
            while (myRs.next()) {

                // retrieve data from result set row
                int id = myRs.getInt("id");
                String albumTitle = myRs.getString("albumTitle");
                String albumArtist = myRs.getString("albumArtist");
                int numberOfSongs = myRs.getInt("numberOfSongs");
                String songTitle = myRs.getString("songTitle");
                int songNumber = myRs.getInt("songNumber");

                // create new student object
                Song tempSong = new Song(id, albumTitle, albumArtist,
                        numberOfSongs, songTitle, songNumber);

                // add it to the list of songs
                songs.add(tempSong);
            }

            return songs;
        }
        finally {
            close (myConn, myStmt, myRs);
        }
    }

    public void addSong(Song theSong) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            myConn = getConnection();

            String sql = "insert into musicTbl (albumTitle, albumArtist, numberOfSongs, songTitle, songNumber ) values (?, ?, ?, ?, ?)";

            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setString(1, theSong.getAlbumTitle());
            myStmt.setString(2, theSong.getAlbumArtist());
            myStmt.setInt(3, theSong.getNumberOfSongs());
            myStmt.setString(4, theSong.getSongTitle());
            myStmt.setInt(5, theSong.getSongNumber());


            myStmt.execute();
        }
        finally {
            close (myConn, myStmt);
        }

    }

    public Song getSong(int songId) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = getConnection();

            String sql = "select * from musicTbl where id=?";

            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, songId);

            myRs = myStmt.executeQuery();

            Song theSong = null;

            // retrieve data from result set row
            if (myRs.next()) {
                int id = myRs.getInt("id");
                String albumTitle = myRs.getString("albumTitle");
                String albumArtist = myRs.getString("albumArtist");
                int numberOfSongs = myRs.getInt("numberOfSongs");
                String songTitle = myRs.getString("songTitle");
                int songNumber = myRs.getInt("songNumber");

                theSong = new Song(id, albumTitle, albumArtist,
                        numberOfSongs, songTitle, songNumber );
            }
            else {
                throw new Exception("Could not find song id: " + songId);
            }

            return theSong;
        }
        finally {
            close (myConn, myStmt, myRs);
        }
    }

    public void updateSong(Song theSong) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            myConn = getConnection();

            String sql = "update musicTbl "
                    + " set albumTitle=?, albumArtist=?, numberOfSongs=?, songTitle=?, songNumber=?"
                    + " where id=?";

            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setString(1, theSong.getAlbumTitle());
            myStmt.setString(2, theSong.getAlbumArtist());
            myStmt.setInt(3, theSong.getNumberOfSongs());
            myStmt.setString(4, theSong.getSongTitle());
            myStmt.setInt(5, theSong.getSongNumber());
            myStmt.setInt(6, theSong.getId());

            myStmt.execute();
        }
        finally {
            close (myConn, myStmt);
        }

    }

    public void deleteSong(int songId) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            myConn = getConnection();

            String sql = "delete from musicTbl where id=?";

            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, songId);

            myStmt.execute();
        }
        finally {
            close (myConn, myStmt);
        }
    }

    private Connection getConnection() throws Exception {

        Connection theConn = dataSource.getConnection();

        return theConn;
    }

    private void close(Connection theConn, Statement theStmt) {
        close(theConn, theStmt, null);
    }

    private void close(Connection theConn, Statement theStmt, ResultSet theRs) {

        try {
            if (theRs != null) {
                theRs.close();
            }

            if (theStmt != null) {
                theStmt.close();
            }

            if (theConn != null) {
                theConn.close();
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}

