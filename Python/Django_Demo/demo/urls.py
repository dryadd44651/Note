from django.urls import path, include
#from . import views
#from .views import another
from rest_framework import routers
from .views import BookViewSet

routers = routers.DefaultRouter()
routers.register('books',BookViewSet)

urlpatterns = [
    path('', include(routers.urls)),
    #path('first',views.first),
    #path('another',another.as_view()),
]
