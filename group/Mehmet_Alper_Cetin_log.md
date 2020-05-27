# CS102 ~ Personal Log page ~
****
## Mehmet Alper Cetin
****

On this page I will keep a weekly record of what I have done for the CS102 group project. This page will be submitted together with the rest of the repository, in partial fulfillment of the CS102 course requirements.

### ~ 24.04.2020 ~
Today we discussed what skills we need to learn, we disturbed the classes. I give a little bit info about QR codes as well.

### ~ 27.04.2020 ~
This week I helped by doing logs, changing personal logs.

### ~ 07.05.2020 ~
I look into QR code, how to create and use them. Found out that it is very diffucult to create a class by yourself for QR code. Although there is an open code in github called ZXing and one provided by google.

### ~ 09.05.2020 ~
Writing places for data to show on map.

### ~ 12.05.2020 ~
wrote the codes of achievements and added labels

### ~ 21.05.2020 ~
I kept on writing achievements package added some activities to show the achievements
and tried to make a code that is buildable. But I didn't manage the time well so
I couldn't write the code for Qr Scanning. I was planning on using  ZXing for the Qr Scan Activity
and I was planning to use free Qr Code writers on web. But although I didn't finish the code for
Qr Scan I think my Achievements package was understandable and buildable.

Resources I used was Bilkent Official cite (https://w3.bilkent.edu.tr/bilkent/) and
FourSquare (https://tr.foursquare.com/) for images and again Bilkent's map to get
information about buildings.
### ~ 27.05.2020 ~
My final comments about the package achievement:

My plan for the qr code achievement was using the qr_button for opening the QrScanActivity
a cam for the user to scan the qr code using ZXing qr code scanner classes to get
the string name of the question and then finding the question with the
Places object's method findByQuestion( String questionName) and then using
Achievable's findQuestion( String name ) method to find the question and then
passing the Question through QrScanActivity  to the QuestionBoard. Then QuestionBoard
is ready to show the question and answering it.
Although Passing objects through activities seems to be a little hard,
as I search it, I think I could of made it by making the object implement Parcelable.
But I couldn't manage the time right so I couldn't finish it.

Overall I think the code is buildable and I think a coder
can come and wrote the code on top of achievement package with ease.
****
