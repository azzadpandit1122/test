package com.azzadpandit.azadproject.Model.NewModel;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Sort implements Serializable, Parcelable {

    @SerializedName("Mid")
    @Expose
    private Integer mid;
    @SerializedName("Tid")
    @Expose
    private Integer tid;
    @SerializedName("amount")
    @Expose
    private Float amount;
    @SerializedName("narration")
    @Expose
    private Long narration;
    public final static Creator<Sort> CREATOR = new Creator<Sort>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Sort createFromParcel(android.os.Parcel in) {
            return new Sort(in);
        }

        public Sort[] newArray(int size) {
            return (new Sort[size]);
        }

    };
    private final static long serialVersionUID = -3050690428082950881L;

    protected Sort(android.os.Parcel in) {
        this.mid = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.tid = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.amount = ((Float) in.readValue((Float.class.getClassLoader())));
        this.narration = ((Long) in.readValue((Long.class.getClassLoader())));
    }

    public Sort() {
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Long getNarration() {
        return narration;
    }

    public void setNarration(Long narration) {
        this.narration = narration;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Sort.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("mid");
        sb.append('=');
        sb.append(((this.mid == null) ? "<null>" : this.mid));
        sb.append(',');
        sb.append("tid");
        sb.append('=');
        sb.append(((this.tid == null) ? "<null>" : this.tid));
        sb.append(',');
        sb.append("amount");
        sb.append('=');
        sb.append(((this.amount == null) ? "<null>" : this.amount));
        sb.append(',');
        sb.append("narration");
        sb.append('=');
        sb.append(((this.narration == null) ? "<null>" : this.narration));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(mid);
        dest.writeValue(tid);
        dest.writeValue(amount);
        dest.writeValue(narration);
    }

    public int describeContents() {
        return 0;
    }

}
