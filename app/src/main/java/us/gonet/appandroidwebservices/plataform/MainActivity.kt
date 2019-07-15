package us.gonet.appandroidwebservices.plataform

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import us.gonet.appandroidwebservices.R
import us.gonet.appandroidwebservices.data.models.ModelCrime
import us.gonet.appandroidwebservices.presentation.MvpInterface

class MainActivity : AppCompatActivity(),MvpInterface.View,MvpInterface.BaseView {

    override fun showToast() {
       Toast.makeText(this, "Se ha hecho la petición existosamente", Toast.LENGTH_LONG).show()
    }

    override fun getContext(): Context {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showSnackBar(message: String, duration: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showToast(message: String, duration: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgressDialog(message: String, cancelable: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dismissProgressDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var recycler:RecyclerView
    private lateinit var adapterRecycler: AdapterRecycler
    private lateinit var basePresenter: BasePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        recycler= recycler_view
        recycler.layoutManager=LinearLayoutManager(this)
        basePresenter= BasePresenter(this)
        basePresenter.onSubscribe()
    }


    override fun showProgressDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showDataListRecyclerView(list: ArrayList<ModelCrime>) {
        adapterRecycler= AdapterRecycler(list)
        recycler.adapter= adapterRecycler
    }
}
