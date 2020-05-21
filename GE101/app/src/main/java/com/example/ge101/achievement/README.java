/*
My plan for the qr code achievement was using qr_button for opening the QrScanActivity
a cam for the user to scan the qr code using ZXing qr code scanner classes to get
the string name of the question and then finding the question with the
Places object we pass through main activity opening the QuestionBoard by passing the question.
The thing is passing objects through activities seems to be a little hard, I think we can do it
by making the object implement Parcelable. Overall I think the code is buildable and I think a coder
can come and wrote the code on top of achievement package with ease.
*/