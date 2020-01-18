package com.ismailsozen.recyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var tumManzaralar = ArrayList<Manzara>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veriKaynaginiDoldur()

        var myAdapter=ManzaraAdapter(tumManzaralar)

        recyclerViewManzara.adapter=myAdapter

        var linearLayoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerViewManzara.layoutManager=linearLayoutManager


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.anamenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        //hangi ögeye tıklanıldığını alıyor
        var id=item?.itemId

        when(id){

            R.id.menulinearViewHorizontal->{
                var linearLayoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
                recyclerViewManzara.layoutManager=linearLayoutManager

            }

            R.id.menulinearViewVertical->{

                var menulinearViewVertical=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
                recyclerViewManzara.layoutManager=menulinearViewVertical
            }

        }


        return super.onOptionsItemSelected(item)
    }


    fun veriKaynaginiDoldur():ArrayList<Manzara> {
        var tumResimler = arrayOf(
            R.drawable.r1,
            R.drawable.r2,
            R.drawable.r3,
            R.drawable.r4,
            R.drawable.r5,
            R.drawable.r6,
            R.drawable.r7,
            R.drawable.r8
        )


        for (i in 0..tumResimler.size-1)
        {

            var eklenecekManzara=Manzara("Manzara "+i,"Açıklama",tumResimler[i])
            tumManzaralar.add(eklenecekManzara)


        }

    return tumManzaralar
    }

}
