package com.sulistyo.cobalagi

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val listNegara = ArrayList<Negara>()

    val nama_negara = listOf("Amerika", "Australia", "Brazil", "Japan", "Germany", "Indonesia", "England")

    val url_bendera = listOf(
        "http://flags.fmcdn.net/data/flags/w580/us.png",
        "http://flags.fmcdn.net/data/flags/w580/au.png",
        "http://flags.fmcdn.net/data/flags/w580/br.png",
        "http://flags.fmcdn.net/data/flags/w580/jp.png",
        "http://flags.fmcdn.net/data/flags/w580/de.png",
        "http://flags.fmcdn.net/data/flags/w580/id.png",
        "http://flags.fmcdn.net/data/flags/w580/gb.png"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in nama_negara.indices) {
            listNegara.add(Negara(nama_negara.get(i), url_bendera.get(i)))
        }

        recyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun recyclerList() {
        val mAdapter = NegaraAdapter(applicationContext, listNegara)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mAdapter
        }
    }

    private fun recyclerGrid() {
        val mAdapter = NegaraGridAdapter(applicationContext, listNegara)
        recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = mAdapter
        }
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_list -> recyclerList()
            R.id.action_gridlist -> recyclerGrid()
        }
        return super.onOptionsItemSelected(item)
    }
}
