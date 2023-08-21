package tw.edu.pu.csim.s1102294.azq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.ImageView

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener {

    private lateinit var gDetector: GestureDetector
    private lateinit var imageView: ImageView
    private lateinit var imageView2:ImageView
    private val images = arrayOf(R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e)
    private val images1 = arrayOf(R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e)
    private var currentImageIndex = 0
    private var currentImageIndex1 = 0
    private var screenHeight = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        imageView.setImageResource(images[currentImageIndex])
        imageView2 = findViewById(R.id.imageView2)
        imageView2.setImageResource(images1[currentImageIndex1])

        gDetector = GestureDetector(this, this)
        screenHeight = resources.displayMetrics.heightPixels

//        val quarterScreenHeight = screenHeight/4
//        val imageWidth = (quarterScreenHeight * 4) / 3 // 假設圖片寬高比例為4:3
//        val layoutParams = imageView.layoutParams
//        layoutParams.height = quarterScreenHeight
//        layoutParams.width = imageWidth
//        imageView.layoutParams = layoutParams
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        gDetector.onTouchEvent(event)
        return true
    }

    override fun onDown(p0: MotionEvent): Boolean {
        return true
    }

    override fun onShowPress(p0: MotionEvent) {
    }

    override fun onSingleTapUp(p0: MotionEvent): Boolean {
        return true
    }

    override fun onScroll(p0: MotionEvent, p1: MotionEvent, p2: Float, p3: Float): Boolean {
        return true
    }

    override fun onLongPress(p0: MotionEvent) {

    }

    override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        val imageViewTop = imageView.top
        val imageViewBottom = imageView.bottom
        val imageViewTop2 = imageView2.top
        val imageViewBottom2 = imageView2.bottom
        if(Math.abs(velocityX) > Math.abs(velocityY) &&  e1.y >= imageViewTop && e1.y <= imageViewBottom) {
            //Math.abs(velocityX) > Math.abs(velocityY)判斷是水平滑動還是垂直
            if (e1.x >= e2.x) {
                currentImageIndex++
                if (currentImageIndex >= images.size) {
                    currentImageIndex = 0
                }
            } else {
                currentImageIndex--
                if (currentImageIndex < 0) {
                    currentImageIndex = images.size - 1
                }
            }
        }else if(Math.abs(velocityX) > Math.abs(velocityY) &&  e1.y >= imageViewTop2 && e1.y <= imageViewBottom2) {
            if (e1.x >= e2.x) {
                currentImageIndex1++
                if (currentImageIndex1 >= images1.size) {
                    currentImageIndex1 = 0
                }
            } else {
                currentImageIndex1--
                if (currentImageIndex1 < 0) {
                    currentImageIndex1 = images1.size - 1
                }
            }
        }

        imageView.setImageResource(images[currentImageIndex])
        imageView2.setImageResource(images1[currentImageIndex1])
        return true
    }
}