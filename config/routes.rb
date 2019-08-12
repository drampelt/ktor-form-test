Rails.application.routes.draw do
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
  controller :application do
    post '/ktor_test', action: :ktor_test
  end
end
