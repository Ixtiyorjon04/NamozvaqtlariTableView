package uz.gita.namozvaqtlari.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.evrencoskun.tableview.adapter.AbstractTableAdapter
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder
import uz.gita.namozvaqtlari.data.tableview.Cell
import uz.gita.futboollegueapplication.data.model.tableview.ColumnHeader
import uz.gita.namozvaqtlari.data.tableview.RowHeader
import uz.gita.futboollegueapplication.data.model.tableview.TextCell
import uz.gita.namozvaqtlari.presentation.holders.ColumnHeaderViewHolder
import uz.gita.namozvaqtlari.presentation.holders.RowHeaderViewHolder
import uz.gita.namozvaqtlari.presentation.holders.TextCellViewHolder
import uz.gita.namozvaqtlari.R
import uz.gita.namozvaqtlari.data.tableview.TableDataWrapper
import uz.gita.namozvaqtlari.databinding.TableViewCellLayoutBinding
import uz.gita.namozvaqtlari.databinding.TableViewColumnHeaderLayoutBinding
import uz.gita.namozvaqtlari.databinding.TableViewRowHeaderLayoutBinding


class TableAdapter(private val tableData: TableDataWrapper) :
    AbstractTableAdapter<ColumnHeader, RowHeader, Cell>() {


    private var listener: ((ArrayList<String>) -> Unit)? = null
    fun setListener(block: ((ArrayList<String>) -> Unit)) {
        listener = block
    }

    override fun onCreateCellViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder {
        return TextCellViewHolder(
            TableViewCellLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }


    override fun onBindCellViewHolder(
        holder: AbstractViewHolder,
        cellItemModel: Cell?,
        columnPosition: Int,
        rowPosition: Int
    ) {
        val textCellViewHolder = holder as TextCellViewHolder
        textCellViewHolder.bind(cellItemModel as TextCell)
//            holder.itemView.setOnClickListener {
//                listener!!.invoke(
//                    arrayListOf(
//                        tableData.id[rowPosition].data,
//                        tableData.cells[rowPosition][1].data
//                    )
//                )
//            }

    }

    override fun onCreateColumnHeaderViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AbstractViewHolder =
        ColumnHeaderViewHolder(
            TableViewColumnHeaderLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindColumnHeaderViewHolder(
        holder: AbstractViewHolder,
        columnHeaderItemModel: ColumnHeader?,
        columnPosition: Int
    ) {
        val columnHeaderViewHolder = holder as ColumnHeaderViewHolder
        columnHeaderViewHolder.bind(columnHeaderItemModel!!)
    }

    override fun onCreateRowHeaderViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder =
        RowHeaderViewHolder(
            TableViewRowHeaderLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )


    override fun onBindRowHeaderViewHolder(
        holder: AbstractViewHolder,
        rowHeaderItemModel: RowHeader?,
        rowPosition: Int
    ) {
        val rowHeaderViewHolder = holder as RowHeaderViewHolder
        rowHeaderViewHolder.bind(rowHeaderItemModel!!)
    }

    override fun onCreateCornerView(parent: ViewGroup): View =
        LayoutInflater.from(parent.context).inflate(
            R.layout.table_view_corner_layout, parent, false
        )


    override fun getCellItemViewType(column: Int): Int {
        return 1
    }

}