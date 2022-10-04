package uz.gita.namozvaqtlari.presentation.holders

import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder
import uz.gita.futboollegueapplication.data.model.tableview.TextCell
import uz.gita.namozvaqtlari.databinding.TableViewCellLayoutBinding

class TextCellViewHolder(private val viewBinding: TableViewCellLayoutBinding) :
    AbstractViewHolder(viewBinding.root) {

    fun bind(data: TextCell) {
        viewBinding.cellData.text = data.data
    }

}