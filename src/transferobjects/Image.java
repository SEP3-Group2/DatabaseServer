package transferobjects;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.io.Serializable;
import java.util.Hashtable;

public class Image extends BufferedImage implements Serializable
{
  public Image(int width, int height, int imageType)
  {
    super(width, height, imageType);
  }

  public Image(int width, int height, int imageType, IndexColorModel cm)
  {
    super(width, height, imageType, cm);
  }

  public Image(ColorModel cm, WritableRaster raster,
      boolean isRasterPremultiplied, Hashtable<?, ?> properties)
  {
    super(cm, raster, isRasterPremultiplied, properties);
  }
}
