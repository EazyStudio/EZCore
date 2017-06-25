package vn.eazy.studio.core.example.widgets;

import android.content.Context;
import android.util.AttributeSet;

import vn.eazy.studio.core.widget.EazyTextView;

/**
 * Created by harryle on 6/25/17.
 */

public class BookerlyTextView extends EazyTextView{
    public BookerlyTextView(Context context) {
        super(context);
    }

    public BookerlyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BookerlyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected String createDefaultFont() {
        return "fonts/bookerly/bookerly_regular.ttf";
    }

    @Override
    protected String createLightFont() {
        return createDefaultFont();
    }

    @Override
    protected String createRegularFont() {
        return createDefaultFont();
    }

    @Override
    protected String createMediumFont() {
        return createDefaultFont();
    }

    @Override
    protected String createItalicFont() {
        return createDefaultFont();
    }

    @Override
    protected String createThinFont() {
        return createDefaultFont();
    }

    @Override
    protected String createBoldFont() {
        return "fonts/bookerly/bookerly_bold.ttf";
    }

    @Override
    protected String createBlackFont() {
        return createDefaultFont();
    }
}
