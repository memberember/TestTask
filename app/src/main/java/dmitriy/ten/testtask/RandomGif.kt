package dmitriy.ten.testtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RandomGif : AppCompatActivity() {

    val KEY = "PKM9to3T0lTnWc0uWL2XYH1M3AVANQ6u"
    val ApiDpc = RetrofitClient.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_gif)

        var btnRefrsh = findViewById<Button>(R.id.btn_refresh)

        setRandomImage()
        btnRefrsh.setOnClickListener {
            setRandomImage()
        }
    }


    fun setRandomImage() {
        var ivImage = findViewById<ImageView>(R.id.iv_image)

        ApiDpc.random(
            api_key = KEY,
            rating = "g"
        ).observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->
                Glide.with(this)
                    .asGif()
                    .load(result.data.images.original.url)
                    .placeholder(R.drawable.ic_round_self_improvement_24)
                    .into(ivImage)
            }, { error ->
                Glide.with(this)
                    .load(R.drawable.try_again)
                    .placeholder(R.drawable.ic_round_self_improvement_24)
                    .into(ivImage)
            })
    }
}