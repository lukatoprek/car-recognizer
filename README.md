# Car Recognizer
![First Image]([https://imgur.com/a/ibsIIdN])
![Second Image]([https://imgur.com/a/ibsIIdN])
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
