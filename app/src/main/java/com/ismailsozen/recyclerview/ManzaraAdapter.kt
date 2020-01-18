package com.ismailsozen.recyclerview

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.tek_satir.view.*

class ManzaraAdapter(tumManzaralar: ArrayList<Manzara>):RecyclerView.Adapter<ManzaraAdapter.ManzaraViewHolder>() {


    var manzaralar=tumManzaralar

    override fun getItemCount(): Int {

        return manzaralar.size

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ManzaraViewHolder? {

        //tek satır layout umuz javaya dönüştürüldü(kotlin)
        var inflater=LayoutInflater.from(parent?.context)
        var tekSatirManzara=inflater.inflate(R.layout.tek_satir,parent,false)

        return ManzaraViewHolder(tekSatirManzara)



    }

    override fun onBindViewHolder(holder: ManzaraViewHolder?, position: Int) {
        //ilgili pozisyona göre  veri atama yapılan yer

        var oanolusturulanManzara=manzaralar.get(position)
        holder?.setData(oanolusturulanManzara,position)

       /*  holder?.manzaraBaslik?.text=manzaralar.get(position).baslik
        holder?.manzaraAciklama?.text=manzaralar.get(position).aciklama
        holder?.manzaraResim?.setImageResource(manzaralar.get(position).resim)  */

    }


    //bu class ı kendimiz ekliyoruz,
    // inner yazmamızın nedeni iç class olduğunu belirtmek
    //btn ler içinden manzaralar listesine erişebilmek için
  inner class ManzaraViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {


        //neyi kullanacaksak onu burda tanımlıyoruz, cardview mi textview mi ?

        var tekSatir=itemView as CardView

        var manzaraBaslik=tekSatir.tvBaslik
        var manzaraAciklama=tekSatir.tvAciklama
        var manzaraResim=tekSatir.imgManzara

        var btnKopyala=tekSatir.imgKopyala
        var btnSil=tekSatir.imgSil


        fun setData(oanolusturulanManzara: Manzara, position: Int) {

            manzaraBaslik.text=oanolusturulanManzara.baslik
            manzaraAciklama.text=oanolusturulanManzara.aciklama
            manzaraResim.setImageResource(oanolusturulanManzara.resim)


            btnKopyala.setOnClickListener {

                manzaralar.add(position,oanolusturulanManzara)

                //veri kaynağında olan değişikliği adapter e bildirmek için
                notifyItemInserted(position)

                notifyItemRangeChanged(position,manzaralar.size)
            }


            btnSil.setOnClickListener {

                manzaralar.removeAt(position)
                //veri kaynağında olan değişikliği adapter e bildirmek için
                notifyItemRemoved(position)

                //silinecek position sayısı, mevcut dizimizden büyükse, haberdar etmek için
                notifyItemRangeChanged(position,manzaralar.size)
            }


        }

    }



}