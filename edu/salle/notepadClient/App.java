/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.salle.notepadClient;

import java.util.Calendar;
import java.util.List;

import edu.salle.notepadClient.api.NotepadAPI;
import edu.salle.notepadClient.model.Note;
import edu.salle.nontepadclient.view.NotepadIndex;
/**
 *
 * @author Andrei
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NotepadIndex index = new NotepadIndex();
        index.setVisible(true);
        
    }
    
}
