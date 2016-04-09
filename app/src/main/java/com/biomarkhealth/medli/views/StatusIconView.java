package com.biomarkhealth.medli.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.biomarkhealth.medli.R;
import com.biomarkhealth.medli.lib.CalculatedConstants;

/**
 * Created by cmac147 on 3/26/16.
 */
public class StatusIconView extends ImageView {

    public static final int DAY_DOSES_IMAGE = 1;
    public static final int EVENTS_TODAY_IMAGE = 2;
    public static final int POSITIVE__ROUTINE = 3;
    public static final int NEGATIVE_ROUTINE = 4;
    public static final int TIME_TO_NEXT = 5;

    private int width, height;
    private float xPos, yPos, textSize;

    public StatusIconView(Context context) {
        super(context);
        setupDimensions();
    }

    public StatusIconView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupDimensions();
    }

    public StatusIconView(Context context, AttributeSet attrs, int defaultStyle) {
        super(context, attrs, defaultStyle);
        setupDimensions();
    }

    private void setupDimensions() {
        if (!isInEditMode()) {
            CalculatedConstants constants = CalculatedConstants.getInstance();
            width = constants.EXPLORE_ICON_WIDTH;
            height = constants.EXPLORE_ICON_HEIGHT;

            this.setMaxHeight(height);
            this.setMaxWidth(width);
            this.setMinimumHeight(height);
            this.setMinimumWidth(width);
        } else {
            width = 100;
            height = 100;
            this.setMaxHeight(height);
            this.setMaxWidth(width);
            this.setMinimumHeight(height);
            this.setMinimumWidth(width);
        }
        textSize = height * (33f / 92f);  // Calculated from custom tile images & space where rank text can be placed
    }

    public void defineSpecs(int rank, int type) {

        switch (type) {
            case DAY_DOSES_IMAGE:
                drawFlag(R.drawable.pill, rank);
                break;

            case EVENTS_TODAY_IMAGE:
                drawFlag(R.drawable.events, rank);
                break;

            case POSITIVE__ROUTINE:

                break;

            case NEGATIVE_ROUTINE:

                break;

            case TIME_TO_NEXT:

            default:
                drawFlag(R.drawable.pill, rank);
                break;
        }


    }

    private void initializeRankCoordinates(int drawable, float textWidth) {
        xPos = (width / 2) - (textWidth / 2);
        yPos = height - (height * (39f / 92f)); // Calculated from the event tile image & baseline where rank should be placed

    }

    private void drawFlag(int drawable, int rank) {
        //Create a new image bitmap and attach a brand new canvas to it
        Bitmap finalBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Bitmap outlineBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), drawable), width, height, true);
        Canvas tempCanvas = new Canvas(finalBitmap);

        //Draw the flag outline image bitmap into the drawing canvas
        tempCanvas.drawBitmap(outlineBitmap, 0, 0, null);

        //Draw the rank text inside the flag
        Paint mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(textSize);
        mPaint.setFakeBoldText(true);

        initializeRankCoordinates(drawable, mPaint.measureText(String.valueOf(rank))); // Determine the coordinates where the rank should be written
        tempCanvas.drawText(String.valueOf(rank), xPos, yPos, mPaint);

        //Attach the canvas to the ImageView
        setImageDrawable(new BitmapDrawable(getResources(), finalBitmap));

        //Recycle any obsolete bitmaps
        outlineBitmap.recycle();
    }
}
