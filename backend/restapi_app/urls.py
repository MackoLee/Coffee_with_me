from django.urls import path,include
from rest_framework.routers import DefaultRouter
from .views import *

#router
router= DefaultRouter()
router.register('users',UsersViewSet)
router.register('a',AViewSet)
router.register('stores',StoresViewSet)

urlpatterns = [
    path('api/',include(router.urls)),
]
