package us.gonet.appandroidwebservices.plataform

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import us.gonet.appandroidwebservices.R
import us.gonet.appandroidwebservices.data.models.ModelCrime
import us.gonet.appandroidwebservices.presentation.BasePresenter
import us.gonet.appandroidwebservices.presentation.MvpInterface

class MainActivity : AppCompatActivity(), MvpInterface.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        progressBar.max = 10
        recycler_view.layoutManager = LinearLayoutManager(this)
        val basePresenter = BasePresenter(this)
        basePresenter.handlePetition()
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
        progressBar.progress = 0
    }

    override fun showDataListRecyclerView(list: ArrayList<ModelCrime>) {
        val adapterRecycler = AdapterRecycler(list)
        recycler_view.adapter = adapterRecycler
    }

    override fun showToast() {
        Toast.makeText(this, "Se ha hecho la petición existosamente", Toast.LENGTH_LONG).show()
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.INVISIBLE
    }
}
