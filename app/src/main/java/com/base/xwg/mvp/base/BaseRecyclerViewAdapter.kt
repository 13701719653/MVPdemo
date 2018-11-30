package com.base.xwg.mvp.base

import android.annotation.SuppressLint
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.balysv.materialripple.MaterialRippleLayout
import com.base.xwg.mvp.OnItemClickListener
import com.base.xwg.mvp.OnItemLongClickListener
import com.base.xwg.mvp.R

@SuppressLint("ParcelCreator")
/**
 *
 * @author xwg on 2018/8/6.
 */
abstract class BaseRecyclerViewAdapter<T>() : RecyclerView.Adapter<BaseViewHolder>(), Parcelable {
    lateinit var context: Context
    lateinit var layoutInflater: LayoutInflater
    lateinit var datas: List<T>
    var layoutId: Int = 0
    lateinit var onItemClickListener: OnItemClickListener
    lateinit var onItemLongClickListener: OnItemLongClickListener
    var clickFlag = true//单击事件和长单击事件的屏蔽标识

    constructor(parcel: Parcel) : this() {
        clickFlag = parcel.readByte() != 0.toByte()
    }

    constructor(context: Context, datas: List<T>, layoutId: Int) : this() {
        this.context = context
        this.datas = datas
        this.layoutId = layoutId

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder {
        val holder = BaseViewHolder(layoutInflater.inflate(layoutId, parent, false))
        return holder
//        MaterialRippleLayout.on(holder.getView(R.id.ll_all))
    }

    override fun getItemCount(): Int {
        var result = if (datas == null) 0 else datas.size
        return result
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        bindData(holder, datas.get(position), position)
    }

    abstract fun bindData(holder: BaseViewHolder, data: T, position: Int)
    fun setItemClickListener(listener: OnItemClickListener) {
        this.onItemClickListener = listener
    }

    fun setItemLongClickListener(onItemLongClickListener: OnItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (clickFlag) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

}