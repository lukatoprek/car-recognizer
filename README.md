# Car Recognizer
![First Image](https://i.imgur.com/GkEEwax.png)
![Second Image](https://i.imgur.com/5cC8OzY.jpeg)
## Key Features
*   **AI Model**: ResNet-50 architecture, fine-tuned on 1,343 car model classes from the CompCars dataset.
*   **Cloud Inference**: Model deployed as a **Real-time REST API endpoint** on Azure Machine Learning.
*   **Mobile Application**: Intuitive Android UI for capturing photos or selecting images from the gallery, providing instant results.
*   **Tech Stack**: PyTorch (training), Azure ML (deployment), Kotlin, Jetpack Compose, Retrofit.

## System Architecture
The system consists of three main interconnected parts:

1.  **Backend (AI/ML)**:
    *   Model: ResNet-50 (transfer learning)
    *   Dataset: CompCars (reduced to 1,343 classes)
    *   Deployment: Azure ML Real-time Endpoint
    *   Script: `score.py` for request processing

2.  **API Layer**:
    *   RESTful endpoint on Azure
    *   Accepts Base64-encoded images in JSON format
    *   Returns the predicted model and confidence score

3.  **Client (Android App)**:
    *   Language: Kotlin
    *   UI Framework: Jetpack Compose
    *   Architecture: MVVM with SharedViewModel
    *   Features: Camera, gallery, result display

## Technologies Used
### AI/ML Stack
- **PyTorch** - Deep learning framework
- **Torchvision** - Transforms and pre-trained models
- **Azure Machine Learning** - Model deployment and hosting
- **Scikit-learn** - Evaluation metrics

### Mobile Stack
- **Kotlin** - Programming language
- **Jetpack Compose** - Modern UI toolkit
- **Retrofit** - HTTP client for API calls
- **Coil** - Image loading and display
- **Android CameraX** - Camera management

### Tools & Platforms
- **Android Studio** - Development environment
- **Git & GitHub** - Version control
- **Azure Portal** - Cloud resource management

- ## Model Details

- Architecture: ResNet-50
- Training approach: Transfer learning (ImageNet pretrained weights)
- Number of classes: 1,343
- Input size: 224 × 224 RGB images
- Loss function: CrossEntropyLoss (class weighting + label smoothing)
- Optimizer: AdamW
- Augmentation: MixUp, random crops, rotations, color jitter

- ## Performance

- Validation Accuracy: ~95.5%
- Precision (macro): ~95.3%
- Recall (macro): ~95.4%
- F1-score (macro): ~95.1%

- ## License

This project was developed for educational purposes as part of a university course.

