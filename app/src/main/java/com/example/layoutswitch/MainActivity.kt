package com.example.layoutswitch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var gridLayoutManager: GridLayoutManager
    lateinit var layoutAdapter: LayoutAdapter
    lateinit var imageList:ArrayList<LayoutData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setList()

        gridLayoutManager = GridLayoutManager(this, 2)
        layoutAdapter = LayoutAdapter(imageList,gridLayoutManager)

        recyclerView.adapter = layoutAdapter
        recyclerView.layoutManager = gridLayoutManager
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == R.id.switch_menu) {
            switchLayout()
            switchIcon(item)
            return true

        }
        return super.onOptionsItemSelected(item)


    }


    fun setList() {
       imageList = arrayListOf(
            LayoutData("貓咪照片(一)", "10", "100", R.drawable.cat1),
            LayoutData("貓咪照片(二)", "20", "200", R.drawable.cat2),
            LayoutData("貓咪照片(三)", "30", "300", R.drawable.cat3),
            LayoutData("貓咪照片(四)", "40", "400", R.drawable.cat4),
            LayoutData("貓咪照片(五)", "50", "500", R.drawable.cat5),
            LayoutData("貓咪照片(六)", "60", "600", R.drawable.cat6),
            LayoutData("貓咪照片(七)", "70", "700", R.drawable.cat7),
            LayoutData("貓咪照片(八)", "80", "800", R.drawable.cat8),
            LayoutData("貓咪照片(九)", "90", "900", R.drawable.cat9),
            LayoutData("貓咪照片(十)", "100", "1000", R.drawable.cat10)
        )
    }


    fun switchLayout() {

        when (gridLayoutManager.spanCount) {
            1 -> gridLayoutManager.spanCount = 2
            else -> gridLayoutManager.spanCount = 1

        }

        layoutAdapter.notifyItemChanged(2, layoutAdapter.itemCount)

    }

    fun switchIcon(item: MenuItem) {

        when (gridLayoutManager.spanCount) {

            2 -> item.icon = resources.getDrawable(R.drawable.ic_menu_black_24dp)
            else -> {
                item.icon = resources.getDrawable(R.drawable.ic_view_comfy_black_24dp)
            }
        }


    }


}
