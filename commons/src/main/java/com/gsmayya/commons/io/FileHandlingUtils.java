package com.gsmayya.commons.io;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by gsmayya on 1/8/17.
 */

public class FileHandlingUtils {

  // Might have to redesign. Currently best design.

  /**
   * Utility to read and store into a string file
   * @param ctx Android Context
   * @param resourceId Android raw resource file (under /res/raw)
   * @return
   * @throws IOException
   */
  public String readResourceRawFile(Context ctx, int resourceId) throws IOException {

    StringBuilder sb = new StringBuilder();
    try (
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ctx.getResources().openRawResource(resourceId)))) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        sb.append(line);
        sb.append("\n");
      }
    } catch (IOException e) {
      throw e;
    }
    return sb.toString();
  }


}
