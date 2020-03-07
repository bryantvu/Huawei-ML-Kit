## mlkit-example


## Table of Contents

 * [Introduction](#introduction)
 * [Installation](#installation)
 * [Experience Different Functions](#experience-different-functions)
 * [Supported Environments](#supported-environments)
 * [License](#license)


## Introduction
    The sample code mainly shows the use of Huawei Machine Learning SDK.
	
	Including face recognition, text recognition, image classification, landmark recognition and object detection and tracking.
	
	It includes both camera capture video for real-time detection and still image recognition.
	
    If you want to use cloud analyzer, such as cloud text analyzer(document and cloud text), cloud image classification analyzer, landmark analyzer,
    you need to apply for an agconnect-services.json file in the developer alliance(https://developer.huawei.com/consumer/en/doc/development/HMS-Guides/ml-preparations4),
    replacing the sample-agconnect-services.json in the project.
	Attention: The package name in the sample code can not be used to apply for agconnect-services.json. Please change the package name in the sample code or apply for the package name according to the actual application.
	
    Ability called by the sample:
    1. Face Recognition
		a. MLAnalyzerFactory.getInstance().GetFaceAnalyzer (MLFaceAnalyzerSetting): Create a face recognizer. This is the most core class of face recognition.
		b. MLFaceAnalyzer.setTransactor(): Set the face recognition result processor for subsequent processing of the recognition result.
		c. MLFaceAnalyzerSetting.Factory().SetFeatureType (MLFaceAnalyzerSetting.TYPE_FEATURES): Turn on facial expression and feature detection, including smile, eyes open, beard and age.
		d. MLFaceAnalyzerSetting.Factory().AllowTracing (): Whether to start face tracking mode
		e. LensEngine: camera source that generates continuous image data for detection.
	2. Text Recognition
		a. MLAnalyzerFactory.getInstance().getLocalTextAnalyzer()：Create a device text recognizer.
		b. MLAnalyzerFactory.getInstance().getRemoteTextAnalyzer()：Create a cloud text recognizer.
		c. MLAnalyzerFactory.getInstance().getRemoteDocumentAnalyzer()：Create a cloud document recognizer.
		d. MLTextAnalyzer.asyncAnalyseFrame(frame): Parse text information in pictures.
		e. MLDocumentAnalyzer.asyncAnalyseFrame(frame): Parse document information in pictures.
		f. MLText.getBlocks(): Get text blocks. Generally, a text block represents one line. There is also a case where a text block corresponds to multiple lines.
		g. MLText.Block.getContents(): Get list of text lines(MLText.TextLine).
		h. MLText.TextLine.getContents(): Get the text content of each line(MLText.Word, The device text analyzer returns contains spaced, the cloud text analyzer does not).
		i. MLText.Word.getStringValue(): Gets the word of each line.
		j. MLDocument.getBlocks(): Get document blocks. Generally, a document block represents multiple paragraphs(MLDocument.Block).
        k. MLDocument.getSections(): Get list of document paragraphs(MLDocument.Section).
        l. MLDocument.getLineList(): Get list of document lines(MLDocument.Line).
        m. MLDocument.getWordList(): Get list of document words(MLDocument.Word).
	3. Image Classification
		a. MLAnalyzerFactory.getInstance().getLocalImageClassificationAnalyzer(setting)：Create a device image classifier.
		b. MLAnalyzerFactory.getInstance().getRemoteImageClassificationAnalyzer()：Create a cloud image classifier.
		c. MLImageClassificationAnalyzer.asyncAnalyseFrame(frame): Classify images and generate a MLImageClassification collection, which indicates the category to which the image belongs.
		d. MLImageClassification.getName()：Get the name of the image category, such as pen, phone, computer, etc.
    4. Object Detection And Tracking
		a. MLAnalyzerFactory.getInstance().getLocalObjectAnalyzer(setting)：Creating an object Detector.
		2. MLObjectAnalyzerSetting.Factory.setAnalyzerType(MLObjectAnalyzerSetting.TYPE_VIDEO): Set the recognition mode.
		3. MLOject.getTypePossibility: Get the category name of the object.
		4. MLOject.getTypeIdentity()：Get the ID number of the object.
		5. LensEngine：camera source that generates continuous image data for detection.
	5. Landmark Detection
	    a. MLAnalyzerFactory.getInstance().getRemoteLandmarkAnalyzer(settings)：Create a landmark Detector。
		b. MLRemoteLandmarkAnalyzerSetting.Factory.setLargestNumOfReturns()：Set the maximum number of detection results.
		c. MLRemoteLandmarkAnalyzerSetting.Factory.setPatternType()：Set detection mode.
		d. MLRemoteLandmarkAnalyzer.asyncAnalyseFrame(frame): Parse out all landmark information contained in the picture.

## Installation
    Download the sample code and open in android Studio

## Experience Different Functions
    You can change the main activity in the manifest to experience the different features provided by MLKit

## Supported Environments
	android 4.4 or a later version is recommended.

##  License
    ML Kit example is licensed under the [Apache License, version 2.0](http://www.apache.org/licenses/LICENSE-2.0).