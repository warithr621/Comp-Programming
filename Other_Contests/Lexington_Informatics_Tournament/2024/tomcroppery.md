# misc / a little bit of tomcroppery

## Problem:
Once you crop an image, the cropped part is gone... right??? ~ bookworm

[`image.png`](https://drive.google.com/uc?export=download&id=1APBsAvVmiTUryheOl84mt9_MZdYt9EM6&name=image.png)

## Solution:
Here's what the image looks like when we originally download it.
![image](https://github.com/user-attachments/assets/ec09c1c5-7198-48d8-8ab2-823e041eca7f)

Honestly I don't do a lot of CTF related to forensics, so my first thought was just to run ExifTool.
```
walrusramen@Wariths-Air Downloads % exiftool image.png 
ExifTool Version Number         : 12.78
File Name                       : image.png
Directory                       : .
File Size                       : 1220 kB
File Modification Date/Time     : 2024:08:12 23:07:13-05:00
File Access Date/Time           : 2024:08:12 23:08:01-05:00
File Inode Change Date/Time     : 2024:08:12 23:08:00-05:00
File Permissions                : -rw-r--r--
File Type                       : PNG
File Type Extension             : png
MIME Type                       : image/png
Image Width                     : 928
Image Height                    : 452
Bit Depth                       : 8
Color Type                      : RGB with Alpha
Compression                     : Deflate/Inflate
Filter                          : Adaptive
Interlace                       : Noninterlaced
Warning                         : [minor] Trailer data after PNG IEND chunk
Image Size                      : 928x452
Megapixels                      : 0.419
```

Some stuff caught my eye, such as the minor warning and the deflate/inflate compression. I tried looking into the warning first. The `PNG IEND chunk` is a part of the file's bits, so I used [hexed.it](https://hexed.it/) to try dumping it. I found the hex for `IEND` (`49 45 4E 44`) at the end, but the few bits that occurred after this seemed to be useless.

The next idea was to try looking into the compression. We can use Binwalk to anayze any potential embeded files within a file.
```
walrusramen@Wariths-Air Downloads % binwalk --dd='.*' image.png 

DECIMAL       HEXADECIMAL     DESCRIPTION
--------------------------------------------------------------------------------
0             0x0             PNG image, 928 x 452, 8-bit/color RGBA, non-interlaced
41            0x29            Zlib compressed data, default compression
449394        0x6DB72         PNG image, 928 x 536, 8-bit/color RGBA, non-interlaced
449435        0x6DB9B         Zlib compressed data, compressed
```

Weird, why do we have a PNG image inside of our PNG image? The PNG at position `0` is just the original picture we saw, but the one at `0x6DB72` seems to be a diferent story. Let's fix the file extension name on that extracted file and see what we have.
```
walrusramen@Wariths-Air Downloads % cd _image.png.extracted 
walrusramen@Wariths-Air _image.png.extracted % mv 6DB72 alpha.png
walrusramen@Wariths-Air _image.png.extracted % open alpha.png 
```
And now the moment of truth:
![image](https://github.com/user-attachments/assets/ab59bbb4-e5c6-4fe3-a445-92caaf0c8579)

## Flag
`LITCTF{4cr0p41yp5e_15_k1nd_0f_c001_j9g0s}`

## Some Additional Notes
The Preview app on my Mac let me copy paste the test directly from my image, except it messed up a few characters (copying `l` / `O` instead of `1` / `0`) so I spent a solid few minutes figuring out why my flag was wrong.

Thank you for reading the littest LIT writeup ever :D and no I will not give you my information in order to get a free toaster.

~~For a free LIT T-shirt? That's a different story.~~