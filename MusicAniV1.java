package varun;

import java.awt.Color;
import java.awt.Graphics;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.*;
public class MusicAniV1 {
	public static void main(String args[])
	{
		MusicAniGui mag=new MusicAniGui();
		mag.window();
		try{
		Sequencer sqr= MidiSystem.getSequencer();
		sqr.open();
		int i;
		int[] events={127};
		sqr.addControllerEventListener(mag, events);
		Sequence sq= new Sequence(Sequence.PPQ,4);
		Track tr= sq.createTrack();
		for(i=0;i<=60;i=i+5)
		{
			tr.add(makeEvent(144,1,i,120,i));
			tr.add(makeEvent(176,1,127,120,i+5));
			tr.add(makeEvent(128,1,i,120,i+5));
		}
		int j=i;
		for(i=60;i>=0;i=i-5)
		{
			tr.add(makeEvent(144,1,i,120,j));
			tr.add(makeEvent(176,1,127,120,j+5));
			tr.add(makeEvent(128,1,i,120,j+5));
			j=j+5;
		}
		sqr.setSequence(sq);
		sqr.setTempoInBPM(220);
		sqr.start();
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.print("heyo");
		}
	}
      static MidiEvent makeEvent(int v,int w,int x,int y,int z)
	{
		ShortMessage a= new ShortMessage();
		MidiEvent ev=null;
		try {
			a.setMessage(v,w,x,y);
			ev= new MidiEvent(a,z);
			
			}
		catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ev;
	}
     
}
