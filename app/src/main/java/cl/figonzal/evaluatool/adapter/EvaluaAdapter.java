/*--------------------------------------------------------------
                                                               -
 This file is subject to the terms and conditions defined in   -
 file 'LICENSE', which is part of this source code package.    -
                                                               -
 Autor: Felipe González                                        -
 Email: felipe.gonzalezalarcon94@gmail.com                     -
                                                               -
 Copyright (c) 2020.                                           -
                                                               -
 Last modified 09-03-20 16:51                                  -
 --------------------------------------------------------------*/

package cl.figonzal.evaluatool.adapter;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cl.figonzal.evaluatool.R;
import cl.figonzal.evaluatool.modelo.Evalua;
import io.github.luizgrp.sectionedrecyclerviewadapter.Section;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;

public class EvaluaAdapter extends Section {

    private final String nombre_header;
    private final List<Evalua> subItems;
    private final ClickListener clickListener;

    private boolean expanded = false;

    public EvaluaAdapter(@NonNull String nombre_header, @NonNull List<Evalua> list, ClickListener listener) {
        super(
                SectionParameters.builder()
                        .itemResourceId(R.layout.expandable_list_item)
                        .headerResourceId(R.layout.expandable_list_group)
                        .build()
        );

        this.nombre_header = nombre_header;
        this.subItems = list;
        this.clickListener = listener;
    }

    @Override
    public int getContentItemsTotal() {
        return expanded ? subItems.size() : 0;
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(final RecyclerView.ViewHolder holder, int position) {

        final ItemViewHolder itemViewHolder = (ItemViewHolder) holder;

        Evalua evalua = subItems.get(position);

        itemViewHolder.tv_item_title.setText(evalua.getNombre());
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemRootViewClicked(nombre_header, itemViewHolder.getAdapterPosition());
            }
        });

    }

    @Override
    public void onBindHeaderViewHolder(final RecyclerView.ViewHolder holder) {
        HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;

        headerViewHolder.tv_header_title.setText(nombre_header);
        headerViewHolder.iv_arrow.setImageResource(
                expanded ? R.drawable.ic_keyboard_arrow_up_black_24dp : R.drawable.ic_keyboard_arrow_down_black_24dp
        );

        headerViewHolder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onHeaderRootViewClicked(EvaluaAdapter.this);
            }
        });

    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new HeaderViewHolder(view);
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(final boolean expanded) {
        this.expanded = expanded;
    }

    public interface ClickListener {

        void onHeaderRootViewClicked(@NonNull final EvaluaAdapter section);

        void onItemRootViewClicked(@NonNull final String sectionTitle, final int itemAdapterPosition);
    }

    /**
     * Clase holder para headers de lista expandida
     */
    static class HeaderViewHolder extends RecyclerView.ViewHolder {

        private final View rootView;
        private final TextView tv_header_title;
        private final ImageView iv_arrow;

        HeaderViewHolder(@NonNull View view) {
            super(view);

            rootView = view;
            tv_header_title = view.findViewById(R.id.tv_group);
            iv_arrow = view.findViewById(R.id.iv_arrow);
        }
    }

    /**
     * Clase holder para items de lista expandida
     */
    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_item_title;

        ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_item_title = itemView.findViewById(R.id.tv_child);
        }
    }
}
