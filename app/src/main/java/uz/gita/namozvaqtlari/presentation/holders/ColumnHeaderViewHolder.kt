package uz.gita.namozvaqtlari.presentation.holders

import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder
import uz.gita.futboollegueapplication.data.model.tableview.ColumnHeader
import uz.gita.namozvaqtlari.databinding.TableViewColumnHeaderLayoutBinding

class ColumnHeaderViewHolder(private val viewBinding: TableViewColumnHeaderLayoutBinding) :
    AbstractViewHolder(viewBinding.root) {

    fun bind(data: ColumnHeader) {
        viewBinding.columnHeaderTextView.text = data.data
    }
}