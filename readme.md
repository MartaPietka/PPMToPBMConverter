# PPMToPBMConverter

This is a Java project that provides utilities to convert images in PPM format to PBM, PGM, and PPM formats. The PPM (Portable Pixmap) format is a common image file format used to store portable pixmap images. The PBM (Portable Bitmap) format is a black-and-white image file format, while the PGM (Portable Graymap) format is a grayscale image file format.

**This project provides the following converters:**

PpmToPbmConverter: Converts PPM images to PBM (black-and-white) images:
<img width="1409" alt="Screenshot 2023-04-07 at 12 49 48" src="https://user-images.githubusercontent.com/125610011/230597963-25793734-be6a-41d9-91f8-21ddd053d854.png">

PpmToPgmConverter: Converts PPM images to PGM (grayscale) images.
PpmToPpmConverter: Converts PPM images to negative PPM images.
Additionally, the project provides three grayscale conversion algorithms for use with the PpmToPgmConverter:

RgbToGrayscaleByAverageConverter: Converts RGB values to grayscale by taking the average of the red, green, and blue values.
RgbToGrayscaleByMaxConverter: Converts RGB values to grayscale by taking the maximum value of the red, green, and blue values.
RgbToGrayscaleByWeightConverter: Converts RGB values to grayscale using a weighted sum of the red, green, and blue values.
