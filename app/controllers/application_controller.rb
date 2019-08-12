class ApplicationController < ActionController::Base
  skip_before_action :verify_authenticity_token

  def ktor_test
    parameters = []
    params.each do |key, value|
      unless %w[controller action].include? key
        puts "Parameter: #{key} => #{value}"
        parameters << { key: key, value: value }
      end
    end

    render json: { parameters: parameters }
  end
end
