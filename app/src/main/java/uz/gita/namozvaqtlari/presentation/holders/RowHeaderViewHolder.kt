package uz.gita.namozvaqtlari.presentation.holders

import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder
import uz.gita.namozvaqtlari.data.tableview.RowHeader
import uz.gita.namozvaqtlari.databinding.TableViewRowHeaderLayoutBinding

class RowHeaderViewHolder(private val viewBinding: TableViewRowHeaderLayoutBinding) :
    AbstractViewHolder(viewBinding.root) {

    fun bind(data: RowHeader) {
        viewBinding.rowHeaderTextview.text = data.data
    }

}