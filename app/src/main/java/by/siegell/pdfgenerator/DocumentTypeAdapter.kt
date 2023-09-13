package by.siegell.pdfgenerator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.siegell.pdfgenerator.databinding.ListItemButtonBinding

class DocumentTypeAdapter() :
    ListAdapter<DocumentTypePresentationData, ButtonViewHolder>(
        DocumentTypePresentationDataDiffCallback
    ) {

    var onClick: ((DocumentTypeData) -> Unit) = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonViewHolder {
        return ButtonViewHolder(
            ListItemButtonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ButtonViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding.listItemButton) {
            text = item.typeName
            setOnClickListener {
                onClick(item.payload)
            }
        }
    }
}

class ButtonViewHolder(val binding: ListItemButtonBinding) : ViewHolder(binding.root)