# Django Tutorial

*Harder*

*https://github.com/mdn/django-locallibrary-tutorial*

*Easy*

*https://docs.djangoproject.com/en/3.2/intro/tutorial01/*

## Setup environment
```shell
python -m venv ./env
"./env/scripts/activate"
python -m pip install --upgrade pip
pip3 install django~=3.1
django-admin startproject mysite
cd mysite
python manage.py runserver 8080
http://127.0.0.1:8080/
# python manage.py runserver
# http://127.0.0.1:8000/
```

**Structure**

```shell
mysite/
    manage.py
    mysite/
        __init__.py
        settings.py
        urls.py
        asgi.py
        wsgi.py
settings.py: all the website settings
urls.py: URL-to-view mappings
```

## Create application

```shell
# create the polls application
python manage.py startapp polls
```

**polls structure**

```shell
polls/
    __init__.py
    admin.py
    apps.py
    migrations/
        __init__.py
    models.py
    tests.py
    views.py

```

### Registering the catalog application

**django_projects/locallibrary/locallibrary/settings.py**

```python
INSTALLED_APPS = [
    'django.contrib.admin',
    'django.contrib.auth',
    'django.contrib.contenttypes',
    'django.contrib.sessions',
    'django.contrib.messages',
    'django.contrib.staticfiles',
    # Add our new application
    'polls.apps.PollsConfig', #This object was created for us in /polls/apps.py
]
```

**Default Database**

```python
DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.sqlite3',
        'NAME': BASE_DIR / 'db.sqlite3',
    }
}

```

**Migrations**

```shell
# make the DB migrations file in  /polls/migrations/
python3 manage.py makemigrations
# Create or Update the DB
python3 manage.py migrate
```



## Set URL

**Create `polls/urls.py` for polls routing**

```python
from django.urls import path

from . import views

urlpatterns = [
    path('', views.index, name='index'),
]
```

### View  for  URL

**`polls/views.py`**

```python
from django.http import HttpResponse

def index(request):
    return HttpResponse("Hello, world. You're at the polls index.")
```

**`mysite/urls.py`**

**use include to add `polls.urls`**

```python
from django.contrib import admin
from django.urls import include, path

urlpatterns = [
    path('polls/', include('polls.urls')),
    path('admin/', admin.site.urls),
]
```

## Creating models

**`polls/models.py`**

```python
from django.db import models


class Question(models.Model):
    question_text = models.CharField(max_length=200)
    pub_date = models.DateTimeField('date published')


class Choice(models.Model):
    question = models.ForeignKey(Question, on_delete=models.CASCADE)
    choice_text = models.CharField(max_length=200)
    votes = models.IntegerField(default=0)
```

**Migrate for model**

```shell
python manage.py makemigrations
python3 manage.py migrate
```

**Check SQL data description language (DDL) if need**

*syntax for creating and modifying database objects*

```shell
python manage.py sqlmigrate polls 0001
```

## Creating an admin user

```shell
python manage.py createsuperuser
# login in http://127.0.0.1:8080/admin/
```

![image-20210727231848190](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210727231848190.png)

### Make the poll app modifiable in the admin

**`polls/admin.py`**

```python
from django.contrib import admin

from .models import Question

admin.site.register(Question)
```

**now you can manage Question in admin page**

![image-20210727231916492](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210727231916492.png)

**Register with decorator**

```python
# Register the Admin classes for Choice using the decorator
@admin.register(Choice)
class ChoiceAdmin(admin.ModelAdmin):
    pass
```

![image-20210728221404235](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210728221404235.png)

## templates

**Create HTML templates**

```shell
cd polls
mkdir templates
cd templates
mkdir polls
touch index.html
```

**`polls/templates/polls/index.html`**

**latest_question_list: get from views.py**

```html
{% if latest_question_list %}
    <ul>
    {% for question in latest_question_list %}
        <li><a href="/polls/{{ question.id }}/">{{ question.question_text }}</a></li>
    {% endfor %}
    </ul>
{% else %}
    <p>No polls are available.</p>
{% endif %}
```

**`polls\views.py`**

```python
from django.http import HttpResponse
from django.template import 

from .models import Question


def index(request):
    latest_question_list = Question.objects.order_by('-pub_date')[:]
    # set template
    template = loader.get_template('polls/index.html')
    # pass parameter for template
    context = {
        'latest_question_list': latest_question_list,
    }
    return HttpResponse(template.render(context, request))
```

![image-20210727232035084](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210727232035084.png)

### Generic views

More easy to use, less code

`polls/urls.py`

`views.IndexView.as_view`

```python
from django.urls import path

from . import views

urlpatterns = [
    path('', views.index, name='index'),
    path('class', views.IndexView.as_view(), name='index_class'),

]
```

**`polls/views.py`**

**`class IndexView`**

```python
from django.http import HttpResponse
from django.template import loader

from .models import Question
from django.views import generic


def index(request):
    latest_question_list = Question.objects.order_by('-pub_date')[:]
    template = loader.get_template('polls/index.html')
    context = {
        'latest_question_list': latest_question_list,
    }
    return HttpResponse(template.render(context, request))
# override the get_queryset() method to change the list of records returned
# override get_context_data() in order to pass additional context variables to the template
class IndexView(generic.ListView):
    template_name = 'polls/index.html'
    context_object_name = 'latest_question_list'

    def get_queryset(self):
        """Return the last five published questions."""
        return Question.objects.order_by('-pub_date')[:5]
    def get_context_data(self, **kwargs):
        # Call the base implementation first to get the context
        context = super(IndexView, self).get_context_data(**kwargs)
        # Create any data and add it to the context
        context['some_data'] = 'This is just some data'
        return context
```

![image-20210727232057225](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210727232057225.png)

## Static for  CSS

Create **polls/static/polls/style.css**

```css
li a {
    color: green;
}
```

**`polls/templates/polls/index.html`**

```html
{% load static %}

<link rel="stylesheet" type="text/css" href="{% static 'polls/style.css' %}">
```

**`settings.py`**

set the static URL and Root

```python
STATIC_URL = '/static/'
STATIC_ROOT = ''
```

![image-20210727231731104](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210727231731104.png)

## Customize the admin form

**`polls/admin.py`**

```python
from django.contrib import admin

from .models import Question

# Default
# admin.site.register(Question)

# Smae as Default
# class QuestionAdmin(admin.ModelAdmin):
#     fields = ['pub_date', 'question_text']
# admin.site.register(Question, QuestionAdmin)

# new order
class QuestionAdmin(admin.ModelAdmin):
    # add
    fieldsets = [
        (None,               {'fields': ['question_text']}),
        ('Date information', {'fields': ['pub_date']}),
    ]
    # show
    list_display = ('question_text', 'pub_date')
    # search
    search_fields = ['question_text']
admin.site.register(Question, QuestionAdmin)

```

![image-20210727231653698](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210727231653698.png)

## Enabling sessions

**settings.py**

```python
INSTALLED_APPS = [
    ...
    'django.contrib.sessions',
    ....

MIDDLEWARE = [
    ...
    'django.contrib.sessions.middleware.SessionMiddleware',
    ....
```

**views.py**

*use request.session to store browse number of visits*

```python
class IndexView(generic.ListView):
    template_name = 'polls/index.html'
    context_object_name = 'latest_question_list'
    
    def get_queryset(self):
        """Return the last five published questions."""
        return Question.objects.order_by('-pub_date')[:5]
    def get_context_data(self, **kwargs):
        # Number of visits to this view, as counted in the session variable.
        num_visits = self.request.session.get('num_visits', 0)
        self.request.session['num_visits'] = num_visits + 1
        # Call the base implementation first to get the context
        context = super(IndexView, self).get_context_data(**kwargs)
        # Create any data and add it to the context
        context['num_visits'] = self.request.session['num_visits']
        return context
```

**index.html**

```html
{% load static %}

<link rel="stylesheet" type="text/css" href="{% static 'polls/style.css' %}">
{% if num_visits %}
{{num_visits}}
{% endif %}
{% if latest_question_list %}
    <ul>
    {% for question in latest_question_list %}
        <li><a href="/polls/{{ question.id }}/">{{ question.question_text }}</a></li>
    {% endfor %}
    </ul>
{% else %}
    <p>No polls are available.</p>
{% endif %}
```

![image-20210728224535512](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210728224535512.png)

## Enabling authentication

```python
INSTALLED_APPS = [
    ...
    'django.contrib.auth',  #Core authentication framework and its default models.
    'django.contrib.contenttypes',  #Django content type system (allows permissions to be associated with models).
    ....

MIDDLEWARE = [
    ...
    'django.contrib.sessions.middleware.SessionMiddleware',  #Manages sessions across requests
    ...
    'django.contrib.auth.middleware.AuthenticationMiddleware',  #Associates users with requests using sessions.
    ....

```

![Admin site - add groups or users](https://developer.mozilla.org/en-US/docs/Learn/Server-side/Django/Authentication/admin_authentication_add.png)

### Add users group

![image-20210728225036649](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210728225036649.png)

### Add user

![image-20210728225256470](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210728225256470.png)

![image-20210728225432479](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210728225432479.png)

**mysite/urls.py**

```python
#Add Django site authentication urls (for login, logout, password management)

urlpatterns += [
    path('accounts/', include('django.contrib.auth.urls')),
]

```

Create **templates/registration/login.html**

*To make the **templates** directory visible to the template loader*

**settings.py**

```python
import os # needed by code below
```

```python
    ...
    TEMPLATES = [
      {
       ...
       'DIRS': [os.path.join(BASE_DIR, 'templates')],
       'APP_DIRS': True,
       ...
    
```

Create **templates\base_generic.html**

```html
  <ul class="sidebar-nav">


   {% if user.is_authenticated %}
     <li>User: {{ user.get_username }}</li>
     <li><a href="{% url 'logout'%}?next={{request.path}}">Logout</a></li>
   {% else %}
     <li><a href="{% url 'login'%}?next={{request.path}}">Login</a></li>
   {% endif %} 
  </ul>
  
  {% block content %}{% endblock %}
  
```



Create **/templates/registration/login.html**

*extends our base template and overrides the `content` block*

```html
{% extends "base_generic.html" %}

{% block content %}

  {% if form.errors %}
    <p>Your username and password didn't match. Please try again.</p>
  {% endif %}

  {% if next %}
    {% if user.is_authenticated %}
      <p>Your account doesn't have access to this page. To proceed,
      please login with an account that has access.</p>
    {% else %}
      <p>Please login to see this page.</p>
    {% endif %}
  {% endif %}

  <form method="post" action="{% url 'login' %}">
    {% csrf_token %}
    <table>
      <tr>
        <td>{{ form.username.label_tag }}</td>
        <td>{{ form.username }}</td>
      </tr>
      <tr>
        <td>{{ form.password.label_tag }}</td>
        <td>{{ form.password }}</td>
      </tr>
    </table>
    <input type="submit" value="login" />
    <input type="hidden" name="next" value="{{ next }}" />
  </form>

  {# Assumes you setup the password_reset view in your URLconf #}
  <p><a href="{% url 'password_reset' %}">Lost password?</a></p>

{% endblock %}
```

**settings.py**

```python
# Redirect to home URL after login (Default redirects to /accounts/profile/)
LOGIN_REDIRECT_URL = '/polls'

```

**/templates/registration/logged_out.html**

```html
{% extends "base_generic.html" %}

{% block content %}
  <p>Logged out!</p>
  <a href="{% url 'login'%}">Click here to login again.</a>
{% endblock %}
```

**mysite\polls\templates\polls\index.html**

````
{% extends "base_generic.html" %}
{% block content %}

...

{% endblock %}
````

**login page with user session**

![image-20210802155828293](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210802155828293.png)

**login page without user session**

![image-20210802155843584](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210802155843584.png)

*Secure the polls with session (@login_required, LoginRequiredMixin)*

**`mysite\polls\views.py`**

```python
from django.http import HttpResponse
from django.template import loader

from .models import Question
from django.views import generic
from django.contrib.auth.decorators import login_required, permission_required
from django.contrib.auth.mixins import LoginRequiredMixin

@login_required
def index(request):
    latest_question_list = Question.objects.order_by('-pub_date')[:]
    template = loader.get_template('polls/index.html')
    context = {
        'latest_question_list': latest_question_list,
    }
    return HttpResponse(template.render(context, request))


# override the get_queryset() method to change the list of records returned
class IndexView(LoginRequiredMixin,generic.ListView):
    template_name = 'polls/index.html'
    context_object_name = 'latest_question_list'
    
    def get_queryset(self):
        """Return the last five published questions."""
        return Question.objects.order_by('-pub_date')[:5]
    def get_context_data(self, **kwargs):
        # Number of visits to this view, as counted in the session variable.
        num_visits = self.request.session.get('num_visits', 0)
        self.request.session['num_visits'] = num_visits + 1
        # Call the base implementation first to get the context
        context = super(IndexView, self).get_context_data(**kwargs)
        # Create any data and add it to the context
        context['num_visits'] = self.request.session['num_visits']
        return context
```

### Other Account Page

*We can implement other account page or just use defualt page*

```python
# accounts/ defualt implemented by django.contrib.auth.urls
urlpatterns += [
    path('accounts/', include('django.contrib.auth.urls')),
]

accounts/ login/ [name='login']
accounts/ logout/ [name='logout']
accounts/ password_change/ [name='password_change']
accounts/ password_change/done/ [name='password_change_done']
accounts/ password_reset/ [name='password_reset']
accounts/ password_reset/done/ [name='password_reset_done']
accounts/ reset/<uidb64>/<token>/ [name='password_reset_confirm']
accounts/ reset/done/ [name='password_reset_complete']
```

*Defualt password_reset page*

![image-20210802164315311](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210802164315311.png)

![image-20210802164532190](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210802164532190.png)

**Overwrite **password_reset_form

mysite\templates\registration\password_reset_form.html

```html
{% extends "base_generic.html" %}

{% block content %}
  <form action="" method="post">
  {% csrf_token %}
  {% if form.email.errors %}
    {{ form.email.errors }}
  {% endif %}
      <p>{{ form.email }}</p>
    <input type="submit" class="btn btn-default btn-lg" value="Reset password">
  </form>
{% endblock %}

```

![image-20210802164642983](https://raw.githubusercontent.com/dryadd44651/cloudimg/master/img/image-20210802164642983.png)

## Other Pages

mysite\templates\registration\password_reset_email.html

```html
Someone asked for password reset for email {{ email }}. Follow the link below:
{{ protocol}}://{{ domain }}{% url 'password_reset_confirm' uidb64=uid token=token %}

```

mysite\templates\registration\password_reset_done.html

```html
{% extends "base_generic.html" %}

{% block content %}
  <p>We've emailed you instructions for setting your password. If they haven't arrived in a few minutes, check your spam folder.</p>
{% endblock %}

```

mysite\templates\registration\password_reset_confirm.html

````html
{% extends "base_generic.html" %}

{% block content %}
    {% if validlink %}
        <p>Please enter (and confirm) your new password.</p>
        <form action="" method="post">
        {% csrf_token %}
            <table>
                <tr>
                    <td>{{ form.new_password1.errors }}
                        <label for="id_new_password1">New password:</label></td>
                    <td>{{ form.new_password1 }}</td>
                </tr>
                <tr>
                    <td>{{ form.new_password2.errors }}
                        <label for="id_new_password2">Confirm password:</label></td>
                    <td>{{ form.new_password2 }}</td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Change my password" /></td>
                </tr>
            </table>
        </form>
    {% else %}
        <h1>Password reset failed</h1>
        <p>The password reset link was invalid, possibly because it has already been used. Please request a new password reset.</p>
    {% endif %}
{% endblock %}

````

mysite\templates\registration\password_reset_complete.html

```html
{% extends "base_generic.html" %}

{% block content %}
  <h1>The password has been changed!</h1>
  <p><a href="{% url 'login' %}">log in again?</a></p>
{% endblock %}
```

## RestAPI

mysite\polls\models.py

*add `__str__` for Question model*

```python
from django.db import models


class Question(models.Model):
    question_text = models.CharField(max_length=200)
    pub_date = models.DateTimeField('date published')
    def __str__(self):
        return str(self.question_text)
```

**mysite\polls\urls.py**

```python
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
```

**mysite\polls\views.py**

*class API map to get, post, put and delete method with ORM Object*

```python
from django.http import HttpResponse
from django.template import loader
from django.utils.regex_helper import contains
from django.views.decorators.csrf import csrf_exempt

from .models import Question
from django.views import View, generic
from django.contrib.auth.decorators import login_required, permission_required
from django.contrib.auth.mixins import LoginRequiredMixin
from django.http import JsonResponse
import datetime
import json

@login_required
def index(request):
    latest_question_list = Question.objects.order_by('-pub_date')[:]
    template = loader.get_template('polls/index.html')
    context = {
        'latest_question_list': latest_question_list,
    }
    return HttpResponse(template.render(context, request))


# override the get_queryset() method to change the list of records returned
class IndexView(LoginRequiredMixin,generic.ListView):
    template_name = 'polls/index.html'
    context_object_name = 'latest_question_list'
    
    def get_queryset(self):
        """Return the last five published questions."""
        return Question.objects.order_by('-pub_date')[:5]
    def get_context_data(self, **kwargs):
        # Number of visits to this view, as counted in the session variable.
        num_visits = self.request.session.get('num_visits', 0)
        self.request.session['num_visits'] = num_visits + 1
        # Call the base implementation first to get the context
        context = super(IndexView, self).get_context_data(**kwargs)
        # Create any data and add it to the context
        context['num_visits'] = self.request.session['num_visits']
        return context

# Rest API
from django.utils.decorators import method_decorator
from django.http import QueryDict

@method_decorator(csrf_exempt, name='dispatch')
class API(View):
    #model = Pallet
    def get(self, *args, **kwargs):
        print(kwargs)
        quest = Question.objects.order_by('-pub_date')[:]

        if('num' in kwargs):
            num = kwargs['num']
            if num<len(quest):
                return JsonResponse(quest[num].__str__(), safe=False, status=200)
            else:
                return JsonResponse({}, safe=False, status=200)

        return JsonResponse([q.__str__() for q in quest], safe=False, status=200)
    
    def post(self, request, **kwargs):
        #print(self.request.POST)
        data = json.loads(request.body)
        print(data)
        if 'question_text' in data:
            Question.objects.create(question_text=data['question_text'],pub_date=datetime.date.today())
            return JsonResponse('success', safe=False, status=200)
        return JsonResponse('fail', safe=False, status=200)
    def put(self, request, **kwargs):
        quests = Question.objects.order_by('-pub_date')[:]
        data = json.loads(request.body)
        print(data)
        if('num' in kwargs):
            num = kwargs['num']
            if num<len(quests) and 'question_text' in data:
                #quest[num].question_text = data['question_text']
                quest = Question.objects.order_by('-pub_date')[num]
                quest.question_text = data['question_text']
                quest.save()
                return JsonResponse(quest.__str__(), safe=False, status=200)
            else:
                return JsonResponse('fail', safe=False, status=200)

    def delete(self, request, **kwargs):
        quests = Question.objects.order_by('-pub_date')[:]
        data = json.loads(request.body)
        print(data)
        if('num' in kwargs):
            num = kwargs['num']
            if num<len(quests):
                #quest[num].question_text = data['question_text']
                quest = Question.objects.order_by('-pub_date')[num]
                quest.delete()
                return JsonResponse('success', safe=False, status=200)
            else:
                return JsonResponse('fail', safe=False, status=200)
```



### VsCode

launch.json

```json
{
    // Use IntelliSense to learn about possible attributes.
    // Hover to view descriptions of existing attributes.
    // For more information, visit: https://go.microsoft.com/fwlink/?linkid=830387
    "version": "0.2.0",
    "configurations": [
        {
            "name": "Python: Django",
            "type": "python",
            "request": "launch",
            "program": "${workspaceFolder}\\mysite\\manage.py",
            "args": [
                "runserver"
            ],
            "django": true,
        }
    ]
}
```

