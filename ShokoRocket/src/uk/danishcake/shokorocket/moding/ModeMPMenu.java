package uk.danishcake.shokorocket.moding;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import uk.danishcake.shokorocket.gui.OnClickListener;
import uk.danishcake.shokorocket.gui.Widget;
import uk.danishcake.shokorocket.gui.WidgetPage;

public class ModeMPMenu extends Mode {
	private WidgetPage mWidgetPage = new WidgetPage();
	private SkinProgress mSkin;
	private ModeMenu mMenu;
	
	public ModeMPMenu(ModeMenu menu, SkinProgress skin) {
		mSkin = skin;
		mMenu = menu;
	}
	
	@Override
	public void Setup(Context context) {
		super.Setup(context);
		
		Widget toggleSP = new Widget(mBtnNP, new Rect(mBtnBorder, mScreenHeight - (mBtnSize + mBtnBorder), mBtnSize + mBtnBorder, mScreenHeight - mBtnBorder));
		toggleSP.setText("SP");
		toggleSP.setOnClickListener(new OnClickListener() {
			@Override
			public void OnClick(Widget widget) {
				if(mPendMode == null)
					mPendMode = mMenu;
			}
		});
		
		mWidgetPage.setFontSize(mFontSize);
		mWidgetPage.addWidget(toggleSP);
	}
	
	@Override
	public ModeAction Tick(int timespan) {
		mWidgetPage.Tick(timespan);
		return super.Tick(timespan);
	}
	
	@Override
	public void Redraw(Canvas canvas) {
		mWidgetPage.Draw(canvas);
		super.Redraw(canvas);
	}
	
	@Override
	public void handleTap(int x, int y) {
		mWidgetPage.handleTap(x, y);
	}
}
