package uk.danishcake.shokorocket;

import uk.danishcake.shokorocket.simulation.Direction;
import uk.danishcake.shokorocket.sound.SoundManager;
import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.KeyEvent;

public class ShokoRocketActivity extends Activity {
	
	private GameView mGameView;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	setVolumeControlStream(AudioManager.STREAM_MUSIC);
    	SoundManager.Initialise(getApplicationContext());
        super.onCreate(savedInstanceState);
        /*
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        					 WindowManager.LayoutParams.FLAG_FULLSCREEN);
*/
        mGameView = new GameView(getApplicationContext());
        setContentView(mGameView);
    }
    
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
    	if(keyCode == KeyEvent.KEYCODE_BACK)
    	{
        	if(mGameView.OverrideBack())        		
        		return true;
    	}
		if(keyCode == KeyEvent.KEYCODE_DPAD_DOWN)
		{
			mGameView.HandleDPad(Direction.South);
			return true;
		} else if(keyCode == KeyEvent.KEYCODE_DPAD_UP)
		{
			mGameView.HandleDPad(Direction.North);
			return true;
		} else if(keyCode == KeyEvent.KEYCODE_DPAD_LEFT)
		{
			mGameView.HandleDPad(Direction.West);
			return true;
		} else if(keyCode == KeyEvent.KEYCODE_DPAD_RIGHT)
		{
			mGameView.HandleDPad(Direction.East);
			return true;
		}
		
		return super.onKeyUp(keyCode, event);
    }
}