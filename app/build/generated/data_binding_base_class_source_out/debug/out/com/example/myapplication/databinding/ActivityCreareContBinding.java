// Generated by view binder compiler. Do not edit!
package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.myapplication.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCreareContBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText Email;

  @NonNull
  public final Button Loginbutton;

  @NonNull
  public final EditText Nume;

  @NonNull
  public final EditText Parola;

  @NonNull
  public final EditText Prenume;

  @NonNull
  public final EditText Telefon;

  @NonNull
  public final Button buttonCreareCont;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView13;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView6;

  @NonNull
  public final TextView textView8;

  @NonNull
  public final TextView textView9;

  private ActivityCreareContBinding(@NonNull ConstraintLayout rootView, @NonNull EditText Email,
      @NonNull Button Loginbutton, @NonNull EditText Nume, @NonNull EditText Parola,
      @NonNull EditText Prenume, @NonNull EditText Telefon, @NonNull Button buttonCreareCont,
      @NonNull TextView textView, @NonNull TextView textView13, @NonNull TextView textView2,
      @NonNull TextView textView3, @NonNull TextView textView6, @NonNull TextView textView8,
      @NonNull TextView textView9) {
    this.rootView = rootView;
    this.Email = Email;
    this.Loginbutton = Loginbutton;
    this.Nume = Nume;
    this.Parola = Parola;
    this.Prenume = Prenume;
    this.Telefon = Telefon;
    this.buttonCreareCont = buttonCreareCont;
    this.textView = textView;
    this.textView13 = textView13;
    this.textView2 = textView2;
    this.textView3 = textView3;
    this.textView6 = textView6;
    this.textView8 = textView8;
    this.textView9 = textView9;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCreareContBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCreareContBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_creare_cont, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCreareContBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Email;
      EditText Email = rootView.findViewById(id);
      if (Email == null) {
        break missingId;
      }

      id = R.id.Loginbutton;
      Button Loginbutton = rootView.findViewById(id);
      if (Loginbutton == null) {
        break missingId;
      }

      id = R.id.Nume;
      EditText Nume = rootView.findViewById(id);
      if (Nume == null) {
        break missingId;
      }

      id = R.id.Parola;
      EditText Parola = rootView.findViewById(id);
      if (Parola == null) {
        break missingId;
      }

      id = R.id.Prenume;
      EditText Prenume = rootView.findViewById(id);
      if (Prenume == null) {
        break missingId;
      }

      id = R.id.Telefon;
      EditText Telefon = rootView.findViewById(id);
      if (Telefon == null) {
        break missingId;
      }

      id = R.id.buttonCreareCont;
      Button buttonCreareCont = rootView.findViewById(id);
      if (buttonCreareCont == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = rootView.findViewById(id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.textView13;
      TextView textView13 = rootView.findViewById(id);
      if (textView13 == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = rootView.findViewById(id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = rootView.findViewById(id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = rootView.findViewById(id);
      if (textView6 == null) {
        break missingId;
      }

      id = R.id.textView8;
      TextView textView8 = rootView.findViewById(id);
      if (textView8 == null) {
        break missingId;
      }

      id = R.id.textView9;
      TextView textView9 = rootView.findViewById(id);
      if (textView9 == null) {
        break missingId;
      }

      return new ActivityCreareContBinding((ConstraintLayout) rootView, Email, Loginbutton, Nume,
          Parola, Prenume, Telefon, buttonCreareCont, textView, textView13, textView2, textView3,
          textView6, textView8, textView9);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
