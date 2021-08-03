from django.urls import path

from . import views

urlpatterns = [
    path('', views.index, name='index'),
    path('class', views.IndexView.as_view(), name='index_class'),
    
]

# Rest API
urlpatterns += [
    path('api/', views.API.as_view(), name='api get all'),
    path('api/<int:num>', views.API.as_view(), name='api'),
]