package io.greatbone.sample;

import io.greatbone.grid.*;

/**
 */
public class Transact extends GridData<Transact> {

    //
    // COLUMNS

    static final KEY ID = new KEY(8);

    static final STRING TEXT = new STRING(128);

    static final BINARY ICON = new BINARY((byte) 32);

    //
    // ACCESSORS

    public String getId() {
        return ID.getValue(this);
    }

    public void setId(String id) {
        ID.putValue(this, id);
    }

    public String getText() {
        return TEXT.getValue(this);
    }

    public void setText(String v) {
        TEXT.putValue(this, v);
    }

    public byte[] getIcon() {
        return ICON.get(this);
    }

    public void setIcon(byte[] v) {
        ICON.put(this, v);
    }


    //
    // SCHEMA

    @Override
    protected GridSchema<Transact> schema() {
        return SCHEMA;
    }

    static final GridSchema<Transact> SCHEMA = new GridSchema<>(Transact.class);

}
