package Audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sonido{
	File sf;
	AudioFileFormat aff;
	AudioInputStream ais;
	Clip  ol;
	
	public Sonido(String path){
       sf = new File(path);
	   try  {
		   aff = AudioSystem.getAudioFileFormat(sf);
		   ais = AudioSystem.getAudioInputStream(sf);
		   AudioFormat af = aff.getFormat();
		   DataLine.Info info = new DataLine.Info(Clip.class,ais.getFormat(),((int) ais.getFrameLength() *af.getFrameSize()));
		   ol = (Clip) AudioSystem.getLine(info);
		   
	   }
	   catch(UnsupportedAudioFileException ee){}
	   catch(IOException ea){}
	   catch(LineUnavailableException LUE){};
    }

	private void play(Clip ol) throws LineUnavailableException, IOException {
		if (!ol.isOpen()){
			ol.open(ais);
		}else ol.setFramePosition(0);
		ol.start();
		
	}

	public int getTime() {
		return ol.getFrameLength();
	}
	
	public void play(){
		try {
			play(ol);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isPlaying() {
		return ol.isActive();
	}
	
	public void stop(){
		if (ol.isRunning())
			ol.stop();
	}
	
}
