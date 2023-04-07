# PPMToPBMConverter

Is a command-line tool for converting PPM image files to PBM, PGM and PPM image files.

## Table of contents
* [General info](#general-info)
* [Setup](#setup)
* [Dependencies](#dependencies)
* [Contributing](#contributing)


## General info

This is a Java project that provides utilities to convert images in PPM format to PBM, PGM, and PPM formats. The PPM (Portable Pixmap) format is a common image file format used to store portable pixmap images. The PBM (Portable Bitmap) format is a black-and-white image file format, while the PGM (Portable Graymap) format is a grayscale image file format.


**This project provides the following converters:**

PpmToPbmConverter: Converts PPM images to PBM (black-and-white) images:

<img width="1409" alt="Screenshot 2023-04-07 at 12 49 48" src="https://user-images.githubusercontent.com/125610011/230597963-25793734-be6a-41d9-91f8-21ddd053d854.png">



PpmToPgmConverter: Converts PPM images to PGM (grayscale) images:

<img width="1411" alt="Screenshot 2023-04-07 at 12 51 49" src="https://user-images.githubusercontent.com/125610011/230598925-3886279e-9098-468d-86b4-dec9eef0c8c3.png">



PpmToPpmConverter: Converts PPM images to negative PPM images:

<img width="1412" alt="Screenshot 2023-04-07 at 12 52 20" src="https://user-images.githubusercontent.com/125610011/230599007-bfc8746a-3f71-4cb2-ab89-b05323ad890e.png">




**Additionally, the project provides three grayscale conversion algorithms for use with the PpmToPgmConverter:**

RgbToGrayscaleByAverageConverter: Converts RGB values to grayscale by taking the average of the red, green, and blue values:

<img width="1411" alt="Average" src="https://user-images.githubusercontent.com/125610011/230599125-38cd600a-ee49-48d9-b6b1-4707ccd51b04.png">



RgbToGrayscaleByMaxConverter: Converts RGB values to grayscale by taking the maximum value of the red, green, and blue values:

<img width="1412" alt="Max" src="https://user-images.githubusercontent.com/125610011/230599180-53ac9885-6d26-40a0-9fa1-777809030e5a.png">



RgbToGrayscaleByWeightConverter: Converts RGB values to grayscale using a weighted sum of the red, green, and blue values:

<img width="1414" alt="Weight" src="https://user-images.githubusercontent.com/125610011/230599229-3139afbf-065e-40fd-8087-ee44b23a5355.png">




**The project also converts PPM format images to black-and-white image based on user-defined threshold values:**

<img width="1311" alt="Threshold" src="https://user-images.githubusercontent.com/125610011/230599879-229db3c9-333e-40ba-a85e-798b5bdf48d4.png">

The left image was generated for the threshold value of 128, while the right one for 210.


## Setup


## Dependencies

**This project uses the following dependencies:**

* JUnit Jupiter API (version 5.9.2) for unit testing
* JUnit Jupiter Params (version 5.9.2) for parameterized testing
* AssertJ Core (version 3.24.2) for assertion testing


## Contributing

If you find any issues with this project, please report them on the GitHub issue tracker. Pull requests are also welcome!
