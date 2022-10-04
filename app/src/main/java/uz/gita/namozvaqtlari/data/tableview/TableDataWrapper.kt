package uz.gita.namozvaqtlari.data.tableview

import uz.gita.futboollegueapplication.data.model.tableview.ColumnHeader

data class TableDataWrapper(
    val rowHeaders: List<RowHeader>,
    val columnHeaders: List<ColumnHeader>,
    val cells: List<List<Cell>>,
)